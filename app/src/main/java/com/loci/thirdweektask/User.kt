package com.loci.thirdweektask

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User(var name: String, var username: String, var password: String): Parcelable