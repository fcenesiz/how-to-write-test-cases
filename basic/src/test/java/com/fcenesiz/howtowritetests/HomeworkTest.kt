package com.fcenesiz.howtowritetests

import com.google.common.truth.Truth.*
import org.junit.Test

class HomeworkTest {

    @Test
    fun `negative input returns -1`(){
        val result = Homework.fib(-15)
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun `left braces count equals to right braces count returns true`(){
       val result = Homework.checkBraces("x = 15 / (4 * 7)")

        assertThat(result).isTrue()
    }

}