package com.mrd.exhibition.buildsrc;

import com.google.gson.Gson;

import org.gradle.BuildResult;
import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;


public class AutoExPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {


        final Task pluginTest = project.task("autoExTest");
        pluginTest.setGroup("autoEx");
        pluginTest.doLast(new Action<Task>() {
            @Override
            public void execute(Task task) {
                System.out.println("Test测试");
                DoHandleService.search("Test测试",5);
            }
        });


        project.getGradle().buildFinished(new Action<BuildResult>() {
            @Override
            public void execute(BuildResult buildResult) {

                Throwable failure = buildResult.getFailure();
                if (failure != null) {
                    DoHandleService.search(failure.getCause().getCause().getMessage(),5);
                } else {
                    System.out.println("没有异常，这很棒！");
                }
            }
        });





    }


//        project.gradle.buildFinished { buildResult ->
//                def failure = buildResult.getFailure()
//            if (failure != null) {
//                System.err.println("注意异常：")
//                System.err.println(failure.cause.cause.message)
//            } else {
//                println "完美编译"
//            }
//        }
//
//        void getStackTrace(Throwable throwable) {
//            if (throwable.cause != 'null') {
//                def message = throwable.cause.message
//                System.out.println(message)
//                getStackTrace(throwable.cause)
//            }
//        }
//
//
//    }


}
