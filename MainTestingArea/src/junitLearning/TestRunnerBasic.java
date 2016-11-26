package junitLearning;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerBasic {
    public static void main(String[] args) {
        //Result resultBigInteger = JUnitCore.runClasses(TestBigInteger.class);
        Result resultTestDoubleLinkedList = JUnitCore.runClasses(TestDoubleLinkedList.class);


//		for (Failure failure : resultBigInteger.getFailures()) {
//
//			System.out.println(failure.toString());
//		}
//		System.out.println("failure count : " + resultBigInteger.getFailureCount());
//		System.out.println("\nWasSuccessfull:        "  +resultBigInteger.wasSuccessful());
        for (Failure failure : resultTestDoubleLinkedList.getFailures()) {

            System.out.println(failure.toString());
            System.out.println(failure.getTrace());
        }
        System.out.println("failure count : " + resultTestDoubleLinkedList.getFailureCount());
        System.out.println("\nWasSuccessfull:        " + resultTestDoubleLinkedList.wasSuccessful());

    }
}
