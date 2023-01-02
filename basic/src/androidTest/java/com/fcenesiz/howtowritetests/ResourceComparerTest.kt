package com.fcenesiz.howtowritetests

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceComparerTest{

    private lateinit var resourceComparer : ResourceComparer

    @Before
    fun setup(){
        resourceComparer = ResourceComparer()
    }

    @After
    fun teardown(){
        // for example db.close
    }

    @Test
    fun stringResourceSameAsGivenString_returnsTrue(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "How to write tests")

        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnsFalse(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Holaa")

        assertThat(result).isFalse()
    }

}