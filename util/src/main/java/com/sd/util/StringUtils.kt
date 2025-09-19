package com.sd.util

import java.math.BigInteger
import java.security.MessageDigest

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(this.toByteArray())
    val bigInt = BigInteger(1, digest)
    return bigInt.toString(16).padStart(32, '0')
}