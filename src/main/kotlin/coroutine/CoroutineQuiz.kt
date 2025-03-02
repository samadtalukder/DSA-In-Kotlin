package com.samad_talukder.coroutine

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import kotlin.coroutines.coroutineContext

fun main() {
    whileLoop()
    //dispatchers()
    //cancellationException()
    //onTextChanged("hello")
    //copyFile()
}

/**
 * What are the ways to launch a coroutine?
 *
 * - launch() method called in a CoroutineScope
 * - launch() method called in a suspend function
 * - async() + await()
 * */

/**
 * What's the result of calling this function?
 *
 * - It's gonna cancel immediately without printing anything
 * - It's gonna cancel after 5 seconds without printing anything
 * - It's gonna print Hello endlessly
 * - It's gonna be printing Hello for 5 seconds and cancel the scope
 * */
fun whileLoop() {
    val scope = CoroutineScope(Job())
    scope.launch {
        launch {
            while (true) {
                println("Hello")
            }
        }
        delay(10000)
        scope.cancel()
    }
}

/**
 * What will be printed after calling this function?
 *
 * - Hello
 * - Hello and Hello Flow
 * - Nothing
 * - Hello Flow
 */
suspend fun flowLaunch() {
    val scope = CoroutineScope(Job())
    val flow = MutableSharedFlow<String>()

    /* flow.onStart {
         emit("Hello, Flow!")
     }.collect(println("it"))*/

    scope.launch {
        println("Hello")
    }
}

/**
 * What will be printed after executing this code?
 *
 * - 1 - Dispatchers.IO, 2 - Dispatchers.IO, 3 - Dispatchers.IO
 * - 1 - Dispatchers.Main, 2 - Dispatchers.IO, 3 - Dispatchers.Main
 * - 1 - Dispatchers.IO, 2 - Dispatchers.IO, 3 - Dispatchers.Main
 * - 1 - Dispatchers.IO, 2 - Dispatchers.IO, 3 - Dispatchers.Default
 */
@OptIn(ExperimentalStdlibApi::class)
fun dispatchers() {
    val scope = CoroutineScope(Dispatchers.Main)

    flow { emit(1) }
        .onEach { println("$it: ${coroutineContext[CoroutineDispatcher]}") }
        .flowOn(Dispatchers.IO)
        .flowOn(Dispatchers.Main)
        .map { it + 1 }
        .onEach { println("$it: ${coroutineContext[CoroutineDispatcher]}") }
        .flowOn(Dispatchers.IO)
        .map { it + 1 }
        .onEach { println("$it: ${coroutineContext[CoroutineDispatcher]}") }
        .launchIn(scope)

}

/**
 * Will the CancellationException be propagated to other coroutines in the scope?
 * - Yes, but only to father
 * - Yes, but only to mom
 * - Yes, both to father and mom
 * - No, CancellationException doesn't propagate upwards
 */
fun cancellationException() {
    val scope = CoroutineScope(Job())
    scope.launch {
        println("grandfather")
        launch {
            try {
                println("father")
                delay(1000)
            } catch (e: Exception) {
                println("father exception: $e")
            }

            launch {
                println("son")
                throw CancellationException()
            }
        }

        launch {
            try {
                println("mom")
                delay(1000)
            } catch (e: Exception) {
                println("mom exception: $e")
            }
        }


    }
}

/**
 * Select correct statements
 * - When any child coroutine in a regular scope fails, all the other children are cancelled as well.
 * - When any child coroutine in a regular scope fails, all the other children are not cancelled.
 * - Using a SupervisorJob prevents other child coroutines from failing when one fails.
 * - SupervisorJob is a default CoroutineScope context that prevents the failure of other child coroutines when one fails.
 */
private val query = MutableSharedFlow<String>()

fun onTextChanged(text: String) = query.tryEmit(text)

private suspend fun search() {
    fun apiRequest() = flowOf("response")
    // Option A
    query.debounce(5000)
        .flatMapLatest { apiRequest() }
        .collect {}
    // Option B
    query.debounce(5000)
        .flatMapMerge { apiRequest() }
        .collect {}
    // Option C
    query.debounce(5000)
        .flatMapConcat { apiRequest() }
        .collect {}
}

/**
 * Which option is the best if you want to implement downloading multiple files simultaneously?
 * - Option A
 * - Option B
 * - Option C
 */
private val download = MutableSharedFlow<String>()

fun onDownloadClicked(url: String) = download.tryEmit(url)

private suspend fun download() {
    fun downloadSongUrl(url: String) = flowOf("response")
    // Option A
    download.debounce(500)
        .flatMapLatest { url -> downloadSongUrl(url) }
        .collect {}
    // Option B
    download.debounce(500)
        .flatMapMerge { url -> downloadSongUrl(url) }
        .collect {}
    // Option C
    download.debounce(500)
        .flatMapConcat { url -> downloadSongUrl(url) }
        .collect {}
}


/**
 * How to combine results of two API requests
 *
 * - Use two coroutines created with async{}
 * - Use two coroutines created with launch{}
 * - Use merge(request1Flow, request2Flow)
 * - Use combine(request1Flow, request2Flow, { a, b ->})
 */

/**
 * Select correct statements
 *
 * - Hot flow starts when flow is collected
 * - Cold flow starts when flow is collected
 * - Hot flow starts immediately without any collector
 * - Cold flow starts immediately without any collector
 * - SharedFlow is a hot Flow
 * - SharedFlow is a cold Flow
 */

/**
 * Which statement is true?
 * - File will always be deleted
 * - The file won't be deleted if any exception is thrown during copying
 * - The file won't be deleted if the coroutine job is canceled during copying
 * - File will never be deleted
 *
 */
private suspend fun copyFile() = withContext(Dispatchers.IO) {
    val file = File("path")
    val newFile = FileOutputStream(File("newFile"))

    try {
        FileInputStream(file).copyTo(newFile)
    } finally {
        removeFile(file)
    }
}

private suspend fun removeFile(file: File) = withContext(Dispatchers.IO) {
    file.delete()
}

/**
 * What will be printed after executing this code?
 *
 * - flowOf, Dispatchers.IO and flow{}, Dispatchers.Default
 * - flowOf, Dispatchers.IO and flow{}, Dispatchers.IO
 * - flowOf, Dispatchers.Default and flow{}, Dispatchers.IO
 * - flowOf, [Parent scope dispatcher] and flow{}, Dispatchers.IO
 *
 */

private suspend fun flowVsFlowOf() {
    val scope = CoroutineScope(Dispatchers.Default)

    fun create(method: String): String {
        //println("$method, ${coroutineContext[CoroutineDispatcher]}")
        return "test"
    }

    flowOf(create("flowOf"))
        .flowOn(Dispatchers.IO)
        .launchIn(scope)

    flow { emit(create("flow{}")) }
        .flowOn(Dispatchers.IO)
        .launchIn(scope)
}

/*
* Correct Answer
*
* 1. It's gonna print Hello endlessly
* 2. launch() method called in a CoroutineScope, async() + await()
* 3. Hello Flow
* 4.
* 5. No, CancellationException doesn't propagate upwards
* 6. When any child coroutine in a regular scope fails, all the other children are cancelled as well, Using a SupervisorJob prevents other child coroutines from failing when one fails.
* 7. Option A
* 8. Option B
* 9. Use two coroutines created with async{}, Use combine(request1Flow, request2Flow, { a, b ->})
* 10. Cold flow starts when flow is collected, Hot flow starts immediately without any collector, SharedFlow is a hot Flow
* 11. The file won't be deleted if the coroutine job is canceled during copying
* 12. flowOf, [Parent scope dispatcher] and flow{}, Dispatchers.IO
*
* */
