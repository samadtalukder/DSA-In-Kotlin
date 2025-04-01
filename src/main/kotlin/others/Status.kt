package com.samad_talukder.others

sealed class TransferStatus {
    data object Success : TransferStatus()
    data object InProgress : TransferStatus()
    data object Failed : TransferStatus()
}

sealed class TransferStatusCons(val code: String) {
    data object Success : TransferStatusCons("200")
    data object InProgress : TransferStatusCons("100")
    data object Failed : TransferStatusCons("404")
}