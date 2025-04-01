package com.samad_talukder.others

fun main() {
    getStatus(TransferStatus.Success)
    getStatusCons(TransferStatusCons.InProgress)
}

fun getStatus(status: TransferStatus) {
    when (status) {
        is TransferStatus.Success -> {
            println("Transfer Success")
        }

        is TransferStatus.InProgress -> {
            println("Transfer In-progress")
        }

        is TransferStatus.Failed -> {
            println("Transfer Failed")
        }
    }
    //println(checkStatus)
}

fun getStatusCons(status: TransferStatusCons) {
    when (status) {
        is TransferStatusCons.Success -> {
            println("${status.code} -> Transfer Success")
        }

        is TransferStatusCons.InProgress -> {
            println("${status.code} -> Transfer In-progress")
        }

        is TransferStatusCons.Failed -> {
            println("${status.code} -> Transfer Failed")
        }
    }
    //println(checkStatus)
}

