package com.infoshareacademy.api;
 
 import static org.hamcrest.core.Is.is;
 import static org.junit.Assert.assertThat;
 
 import org.junit.Before;
 import org.junit.Test;
 
 public class GoogleTranslateTest {
 
     public static final String API_KEY = "AIzaSyDU8mB0ggBXlq3j5n_RChUAyfJh68KZTiU";
 
     private GoogleTranslate googleTranslate;
 
     @Before
     public void setUp() {
         googleTranslate = new GoogleTranslate(API_KEY);
     }
 
     @Test
     public void shouldTranslate() {
         final String input = "Hi, how are you?";
         final String source = "en";
         final String target = "pl";
 
         final String result = googleTranslate.translate(input, source, target);
         assertThat(result, is("Cześć jak się masz?"));
     }
 }
