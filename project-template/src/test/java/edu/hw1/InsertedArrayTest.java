package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InsertedArrayTest {
    @Test
    @DisplayName("Два пустых массива")
    void test1() {
        // given
        int[] arr1 = {};
        int[] arr2 = {};
        // when
        boolean answer = InsertedArray.isInsertable(arr1, arr2);
        // then
        assertThat(answer).isEqualTo(false);
    }
    @Test
    @DisplayName("Первый пустой массив")
    void test2() {
        // given
        int[] arr1 = {};
        int[] arr2 = {2, 3, 4};
        // when
        boolean answer = InsertedArray.isInsertable(arr1, arr2);
        // then
        assertThat(answer).isEqualTo(false);
    }
    @Test
    @DisplayName("Массив является вложенным")
    void test3() {
        // given
        int[] arr1 = {3, 4};
        int[] arr2 = {2, 5, 7};
        // when
        boolean answer = InsertedArray.isInsertable(arr1, arr2);
        // then
        assertThat(answer).isEqualTo(true);
    }
    @Test
    @DisplayName("Min совпадает")
    void test4() {
        // given
        int[] arr1 = {2, 4};
        int[] arr2 = {2, 5, 7};
        // when
        boolean answer = InsertedArray.isInsertable(arr1, arr2);
        // then
        assertThat(answer).isEqualTo(false);
    }
    @Test
    @DisplayName("Max совпадает")
    void test5() {
        // given
        int[] arr1 = {3, 7};
        int[] arr2 = {2, 5, 7};
        // when
        boolean answer = InsertedArray.isInsertable(arr1, arr2);
        // then
        assertThat(answer).isEqualTo(false);
    }
    @Test
    @DisplayName("Не является вложенным")
    void test6() {
        // given
        int[] arr1 = {1, 8};
        int[] arr2 = {2, 5, 7};
        // when
        boolean answer = InsertedArray.isInsertable(arr1, arr2);
        // then
        assertThat(answer).isEqualTo(false);
    }
}
