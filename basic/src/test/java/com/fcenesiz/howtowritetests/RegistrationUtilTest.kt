package com.fcenesiz.howtowritetests

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{

    @Test
    fun `empty username returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Osman",
            "123",
            "123"
        )

        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Ahmet",
            "123",
            "123"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `empty password returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Fatih",
            "",
            ""
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `password was repeated incorrectly returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Fatih",
            "456",
            "123"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `password contains less than 2 digits returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Fatih",
            "abcd3",
            "abcd3"
        )

        assertThat(result).isFalse()
    }

}