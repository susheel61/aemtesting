package com.aemtesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.aemtesting.GuiceModule;
import com.aemtesting.example.AddComponentTest;
import com.cognifide.qa.bb.junit.Modules;
import com.cognifide.qa.bb.junit.concurrent.ConcurrentSuite;

@Modules(GuiceModule.class)
@RunWith(ConcurrentSuite.class)
@Suite.SuiteClasses({AddComponentTest.class})
public class BobcatSuite {

}