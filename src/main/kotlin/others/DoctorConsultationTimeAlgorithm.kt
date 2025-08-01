/**
 * Write an algorithm – in Kotlin – to calculate patient’s estimated waiting time.
 * The algorithm should work for different amount of doctors and patient queue
 * positions – it should accept an array (or arrayList) of Doctor objects and patient’s
 * position in queue as inputs and return the patient’s waiting time as output.
 * Your codes should also include the implementation for the Doctor class.
 * For simplicity, assume all the patients in the queue have no preference for the doctors they want to consult and
 * all the doctors are available and not seeing any patient initially.
 * */
package com.samad_talukder.others

import java.util.*

fun main() {
    val doctors = listOf(
        Doctor("A", 3),
        Doctor("B", 4),
    )

    val patientPosition = 7
    val waitingTime = calculatePatientWaitingTime(doctors, patientPosition)

    println("Estimated waiting time for patient: $waitingTime minutes")
}

data class Doctor(
    val doctorName: String,
    val consultationTime: Int,
    val isAvailable: Boolean = true,
)

/**
 * Calculates the estimated waiting time for a patient given their queue position and available doctors.
 * Algorithm:
 *  - Sort doctors by consultation time (fastest first)
 *  - Simulate patient distribution using a greedy approach
 *  - Always assign the next patient to the doctor who will be free earliest
 *  - Return the waiting time for the patient at the specified position
 *
 *  Algorithm Used: GREEDY ALGORITHM with MIN-HEAP PRIORITY QUEUE
 *
 *  Why Greedy?
 *  - At each step, we make the locally optimal choice (assign patient to earliest available doctor)
 *  - This leads to globally optimal solution for minimizing individual waiting times
 *  - Greedy works here because patient assignment is independent - assigning one patient
 *  - optimally doesn't affect the optimality of future assignments
 *
 * @param doctors List of available doctors
 * @param patientPosition Patient's position in queue (1-based indexing)
 * @return Estimated waiting time in minutes
 */
fun calculatePatientWaitingTime(doctors: List<Doctor>, patientPosition: Int): Int {
    if (doctors.isEmpty() || patientPosition <= 0) return 0

    /**
     * PRIORITY QUEUE SETUP
     * Use a priority queue to efficiently track doctor availability
     *
     * Structure: PriorityQueue<Pair<Int, Doctor>>
     * - First element (Int): Doctor's next free time (PRIORITY KEY)
     * - Second element (Doctor): Doctor object (PAYLOAD)
     *
     * Comparator: compareBy { it.first }
     * - This creates a MIN-HEAP based on free time
     * - Doctor with earliest free time always at the top
     */

    val doctorAvailableQueue = PriorityQueue<Pair<Int, Doctor>>(
        compareBy { it.first } // Sort by free time (ascending)
    )

    /**
     * Initialize all doctors as free at time 0
     * Time Complexity: O(d log d) where d = number of doctors
     *
     * offer() is from Queue interface (more semantic)
     * add() is from Collection interface
     * offer() better expresses "queue operation"
    * */
    doctors.forEach { doctor ->
        doctorAvailableQueue.offer(0 to doctor) // All doctors free at time 0 initially
    }

    /**
     * MAIN ALGORITHM LOOP (Process patients up to the target position)
     * Time Complexity: O(p log d) where p = patient position, d = doctors
     *
     * Why repeat() instead of for loop?
     * - More functional style
     * - Cleaner when we only need iteration count
     * - Automatically handles 0-based indexing
     * */
    repeat(patientPosition) { currentPatient ->
        /**
         * EXTRACT MINIMUM OPERATION
         *
         * poll() vs peek():
         * - poll(): Removes and returns the head (min element) - O(log n)
         * - peek(): Only returns head without removing - O(1)
         *
         * We use poll() because:
         * - We need to update the doctor's free time
         * - Must remove to avoid duplicate processing
         * - Will re-insert with updated time
         */
        val (currentTime, availableDoctor) = doctorAvailableQueue.poll()

        /**
         * TERMINATION CONDITION
         * This is our target patient (0-based indexing in repeat)
         *
         * Why currentPatient == patientQueuePosition - 1?
         * - repeat() uses 0-based indexing (0, 1, 2, ...)
         * - patientQueuePosition is 1-based (1, 2, 3, ...)
         * - When currentPatient = patientQueuePosition - 1, we're at our target
         */
        if (currentPatient == patientPosition - 1) return currentTime

        val nextAvailableTime = currentTime + availableDoctor.consultationTime


        /**
         * UPDATE AND RE-INSERT OPERATION
         * Update doctor's next free time and put back in queue
         *
         * Why update free time?
         * - Doctor is now busy with current patient
         * - Next free time = current free time + consultation duration
         * - Must re-insert to maintain heap property
         *
         * Time Complexity: O(log d) for offer operation
         */
        doctorAvailableQueue.offer((nextAvailableTime) to availableDoctor)
    }

    return 0
}

