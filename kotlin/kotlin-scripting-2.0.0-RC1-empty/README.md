# KT-67727 - Kotlin 2.0.0-RC1 K2 Scripting with empty scripts

https://youtrack.jetbrains.com/issue/KT-67727

Run:
```shell
./gradlew compileKotlin
```

Fails with:

```text
> Task :compileKotlin FAILED
e: org.jetbrains.kotlin.backend.common.BackendException: Backend Internal error: Exception during IR lowering
File being compiled: /Users/paul/src/gradle-related/issue-reproducers/kotlin/kotlin-scripting-2.0.0-RC1-empty/src/main/kotlin/some.gradle.kts
The root cause java.lang.RuntimeException was thrown at: org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:50)
	at org.jetbrains.kotlin.backend.common.CodegenUtil.reportBackendException(CodegenUtil.kt:253)
	at org.jetbrains.kotlin.backend.common.CodegenUtil.reportBackendException$default(CodegenUtil.kt:236)
	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invokeSequential(performByIrFile.kt:65)
	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invoke(performByIrFile.kt:52)
	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invoke(performByIrFile.kt:38)
	at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:166)
	at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:113)
	at org.jetbrains.kotlin.backend.common.phaser.CompositePhase.invoke(PhaseBuilders.kt:29)
	at org.jetbrains.kotlin.backend.common.phaser.CompositePhase.invoke(PhaseBuilders.kt:16)
	at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:166)
	at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:113)
	at org.jetbrains.kotlin.backend.common.phaser.CompilerPhaseKt.invokeToplevel(CompilerPhase.kt:62)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.invokeCodegen(JvmIrCodegenFactory.kt:371)
	at org.jetbrains.kotlin.codegen.CodegenFactory.generateModule(CodegenFactory.kt:47)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.generateModuleInFrontendIRMode(JvmIrCodegenFactory.kt:433)
	at org.jetbrains.kotlin.cli.jvm.compiler.pipeline.CompilerPipelineKt.generateCodeFromIr(compilerPipeline.kt:241)
	at org.jetbrains.kotlin.cli.jvm.compiler.FirKotlinToJvmBytecodeCompiler.runBackend(FirKotlinToJvmBytecodeCompiler.kt:260)
	at org.jetbrains.kotlin.cli.jvm.compiler.FirKotlinToJvmBytecodeCompiler.compileModule(FirKotlinToJvmBytecodeCompiler.kt:160)
	at org.jetbrains.kotlin.cli.jvm.compiler.FirKotlinToJvmBytecodeCompiler.compileModulesUsingFrontendIRAndPsi(FirKotlinToJvmBytecodeCompiler.kt:119)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli(KotlinToJVMBytecodeCompiler.kt:104)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli$default(KotlinToJVMBytecodeCompiler.kt:58)
	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:177)
	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:50)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:104)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:48)
	at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
	at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:453)
	at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:62)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.doCompile(IncrementalCompilerRunner.kt:506)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileImpl(IncrementalCompilerRunner.kt:423)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileNonIncrementally(IncrementalCompilerRunner.kt:301)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compile(IncrementalCompilerRunner.kt:129)
	at org.jetbrains.kotlin.daemon.CompileServiceImplBase.execIncrementalCompiler(CompileServiceImpl.kt:676)
	at org.jetbrains.kotlin.daemon.CompileServiceImplBase.access$execIncrementalCompiler(CompileServiceImpl.kt:92)
	at org.jetbrains.kotlin.daemon.CompileServiceImpl.compile(CompileServiceImpl.kt:1661)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at java.rmi/sun.rmi.server.UnicastServerRef.dispatch(UnicastServerRef.java:359)
	at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:200)
	at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:197)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.rmi/sun.rmi.transport.Transport.serviceCall(Transport.java:196)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:562)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:796)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:677)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:676)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:829)
Caused by: java.lang.RuntimeException: Exception while generating code for:
CONSTRUCTOR visibility:public <> (target:org.gradle.api.Project, Project_1:org.gradle.api.Project) returnType:<root>.Some_gradle [primary]
  VALUE_PARAMETER SCRIPT_CALL_PARAMETER name:target index:0 type:org.gradle.api.Project
  VALUE_PARAMETER SCRIPT_IMPLICIT_RECEIVER name:Project_1 index:1 type:org.gradle.api.Project
  BLOCK_BODY
    DELEGATING_CONSTRUCTOR_CALL 'public constructor <init> (target: org.gradle.api.Project) [primary] declared in org.gradle.kotlin.dsl.precompile.v1.PrecompiledProjectScript'
      target: GET_VAR 'target: org.gradle.api.Project declared in <root>.Some_gradle.<init>' type=org.gradle.api.Project origin=null
    SET_FIELD 'FIELD SCRIPT_CALL_PARAMETER name:target type:org.gradle.api.Project visibility:local [final]' type=kotlin.Unit origin=null
      receiver: GET_VAR '<this>: <root>.Some_gradle declared in <root>.Some_gradle' type=<root>.Some_gradle origin=null
      value: GET_VAR 'target: org.gradle.api.Project declared in <root>.Some_gradle.<init>' type=org.gradle.api.Project origin=null
    SET_FIELD 'FIELD SCRIPT_IMPLICIT_RECEIVER name:$$implicitReceiver_Project type:org.gradle.api.Project visibility:private [final]' type=kotlin.Unit origin=null
      receiver: GET_VAR '<this>: <root>.Some_gradle declared in <root>.Some_gradle' type=<root>.Some_gradle origin=null
      value: GET_VAR 'Project_1: org.gradle.api.Project declared in <root>.Some_gradle.<init>' type=org.gradle.api.Project origin=null
    BLOCK type=kotlin.Unit origin=null

	at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:50)
	at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate$default(FunctionCodegen.kt:42)
	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateMethodNode(ClassCodegen.kt:385)
	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateMethod(ClassCodegen.kt:402)
	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generate(ClassCodegen.kt:169)
	at org.jetbrains.kotlin.backend.jvm.FileCodegen.lower(JvmPhases.kt:41)
	at org.jetbrains.kotlin.backend.common.phaser.PhaseBuildersKt.makeIrFilePhase$lambda$5(PhaseBuilders.kt:114)
	at org.jetbrains.kotlin.backend.common.phaser.PhaseBuildersKt$createSimpleNamedCompilerPhase$1.phaseBody(PhaseBuilders.kt:71)
	at org.jetbrains.kotlin.backend.common.phaser.SimpleNamedCompilerPhase.phaseBody(CompilerPhase.kt:226)
	at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:113)
	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invokeSequential(performByIrFile.kt:62)
	... 49 more
Caused by: java.lang.AssertionError: Assertion failed
	at org.jetbrains.kotlin.backend.jvm.codegen.LineNumberMapper.markLineNumber(LineNumberMapper.kt:72)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.markLineNumber(ExpressionCodegen.kt:204)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitGetValue(ExpressionCodegen.kt:800)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitGetValue(ExpressionCodegen.kt:137)
org.jetbrains.kotlin.backend.common.BackendException: Backend Internal error: Exception during IR lowering
File being compiled: /Users/paul/src/gradle-related/issue-reproducers/kotlin/kotlin-scripting-2.0.0-RC1-empty/src/main/kotlin/some.gradle.kts
The root cause java.lang.RuntimeException was thrown at: org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:50)
	at org.jetbrains.kotlin.backend.common.CodegenUtil.reportBackendException(CodegenUtil.kt:253)
	at org.jetbrains.kotlin.backend.common.CodegenUtil.reportBackendException$default(CodegenUtil.kt:236)
	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invokeSequential(performByIrFile.kt:65)
	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invoke(performByIrFile.kt:52)
	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invoke(performByIrFile.kt:38)
	at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:166)
	at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:113)
	at org.jetbrains.kotlin.backend.common.phaser.CompositePhase.invoke(PhaseBuilders.kt:29)
	at org.jetbrains.kotlin.backend.common.phaser.CompositePhase.invoke(PhaseBuilders.kt:16)
	at org.jetbrains.kotlin.backend.common.phaser.NamedCompilerPhase.phaseBody(CompilerPhase.kt:166)
	at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:113)
	at org.jetbrains.kotlin.backend.common.phaser.CompilerPhaseKt.invokeToplevel(CompilerPhase.kt:62)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.invokeCodegen(JvmIrCodegenFactory.kt:371)
	at org.jetbrains.kotlin.codegen.CodegenFactory.generateModule(CodegenFactory.kt:47)
	at org.jetbrains.kotlin.backend.jvm.JvmIrCodegenFactory.generateModuleInFrontendIRMode(JvmIrCodegenFactory.kt:433)
	at org.jetbrains.kotlin.cli.jvm.compiler.pipeline.CompilerPipelineKt.generateCodeFromIr(compilerPipeline.kt:241)
	at org.jetbrains.kotlin.cli.jvm.compiler.FirKotlinToJvmBytecodeCompiler.runBackend(FirKotlinToJvmBytecodeCompiler.kt:260)
	at org.jetbrains.kotlin.cli.jvm.compiler.FirKotlinToJvmBytecodeCompiler.compileModule(FirKotlinToJvmBytecodeCompiler.kt:160)
	at org.jetbrains.kotlin.cli.jvm.compiler.FirKotlinToJvmBytecodeCompiler.compileModulesUsingFrontendIRAndPsi(FirKotlinToJvmBytecodeCompiler.kt:119)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli(KotlinToJVMBytecodeCompiler.kt:104)
	at org.jetbrains.kotlin.cli.jvm.compiler.KotlinToJVMBytecodeCompiler.compileModules$cli$default(KotlinToJVMBytecodeCompiler.kt:58)
	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:177)
	at org.jetbrains.kotlin.cli.jvm.K2JVMCompiler.doExecute(K2JVMCompiler.kt:50)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:104)
	at org.jetbrains.kotlin.cli.common.CLICompiler.execImpl(CLICompiler.kt:48)
	at org.jetbrains.kotlin.cli.common.CLITool.exec(CLITool.kt:101)
	at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:453)
	at org.jetbrains.kotlin.incremental.IncrementalJvmCompilerRunner.runCompiler(IncrementalJvmCompilerRunner.kt:62)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.doCompile(IncrementalCompilerRunner.kt:506)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileImpl(IncrementalCompilerRunner.kt:423)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compileNonIncrementally(IncrementalCompilerRunner.kt:301)
	at org.jetbrains.kotlin.incremental.IncrementalCompilerRunner.compile(IncrementalCompilerRunner.kt:129)
	at org.jetbrains.kotlin.daemon.CompileServiceImplBase.execIncrementalCompiler(CompileServiceImpl.kt:676)
	at org.jetbrains.kotlin.daemon.CompileServiceImplBase.access$execIncrementalCompiler(CompileServiceImpl.kt:92)
	at org.jetbrains.kotlin.daemon.CompileServiceImpl.compile(CompileServiceImpl.kt:1661)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at java.rmi/sun.rmi.server.UnicastServerRef.dispatch(UnicastServerRef.java:359)
	at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:200)
	at java.rmi/sun.rmi.transport.Transport$1.run(Transport.java:197)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.rmi/sun.rmi.transport.Transport.serviceCall(Transport.java:196)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport.handleMessages(TCPTransport.java:562)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run0(TCPTransport.java:796)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.lambda$run$0(TCPTransport.java:677)
	at java.base/java.security.AccessController.doPrivileged(Native Method)
	at java.rmi/sun.rmi.transport.tcp.TCPTransport$ConnectionHandler.run(TCPTransport.java:676)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:829)
Caused by: java.lang.RuntimeException: Exception while generating code for:
CONSTRUCTOR visibility:public <> (target:org.gradle.api.Project, Project_1:org.gradle.api.Project) returnType:<root>.Some_gradle [primary]
  VALUE_PARAMETER SCRIPT_CALL_PARAMETER name:target index:0 type:org.gradle.api.Project
  VALUE_PARAMETER SCRIPT_IMPLICIT_RECEIVER name:Project_1 index:1 type:org.gradle.api.Project
  BLOCK_BODY
    DELEGATING_CONSTRUCTOR_CALL 'public constructor <init> (target: org.gradle.api.Project) [primary] declared in org.gradle.kotlin.dsl.precompile.v1.PrecompiledProjectScript'
      target: GET_VAR 'target: org.gradle.api.Project declared in <root>.Some_gradle.<init>' type=org.gradle.api.Project origin=null
    SET_FIELD 'FIELD SCRIPT_CALL_PARAMETER name:target type:org.gradle.api.Project visibility:local [final]' type=kotlin.Unit origin=null
      receiver: GET_VAR '<this>: <root>.Some_gradle declared in <root>.Some_gradle' type=<root>.Some_gradle origin=null
      value: GET_VAR 'target: org.gradle.api.Project declared in <root>.Some_gradle.<init>' type=org.gradle.api.Project origin=null
    SET_FIELD 'FIELD SCRIPT_IMPLICIT_RECEIVER name:$$implicitReceiver_Project type:org.gradle.api.Project visibility:private [final]' type=kotlin.Unit origin=null
      receiver: GET_VAR '<this>: <root>.Some_gradle declared in <root>.Some_gradle' type=<root>.Some_gradle origin=null
      value: GET_VAR 'Project_1: org.gradle.api.Project declared in <root>.Some_gradle.<init>' type=org.gradle.api.Project origin=null
    BLOCK type=kotlin.Unit origin=null

	at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:50)
	at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate$default(FunctionCodegen.kt:42)
	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateMethodNode(ClassCodegen.kt:385)
	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generateMethod(ClassCodegen.kt:402)
	at org.jetbrains.kotlin.backend.jvm.codegen.ClassCodegen.generate(ClassCodegen.kt:169)
	at org.jetbrains.kotlin.backend.jvm.FileCodegen.lower(JvmPhases.kt:41)
	at org.jetbrains.kotlin.backend.common.phaser.PhaseBuildersKt.makeIrFilePhase$lambda$5(PhaseBuilders.kt:114)
	at org.jetbrains.kotlin.backend.common.phaser.PhaseBuildersKt$createSimpleNamedCompilerPhase$1.phaseBody(PhaseBuilders.kt:71)
	at org.jetbrains.kotlin.backend.common.phaser.SimpleNamedCompilerPhase.phaseBody(CompilerPhase.kt:226)
	at org.jetbrains.kotlin.backend.common.phaser.AbstractNamedCompilerPhase.invoke(CompilerPhase.kt:113)
	at org.jetbrains.kotlin.backend.common.phaser.PerformByIrFilePhase.invokeSequential(performByIrFile.kt:62)
	... 49 more

	at org.jetbrains.kotlin.ir.expressions.IrGetValue.accept(IrGetValue.kt:18)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.gen(ExpressionCodegen.kt:216)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.generateConstructorArguments(ExpressionCodegen.kt:765)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitDelegatingConstructorCall(ExpressionCodegen.kt:730)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitDelegatingConstructorCall(ExpressionCodegen.kt:137)
	at org.jetbrains.kotlin.ir.expressions.IrDelegatingConstructorCall.accept(IrDelegatingConstructorCall.kt:21)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitStatementContainer(ExpressionCodegen.kt:573)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlockBody(ExpressionCodegen.kt:578)
Caused by: java.lang.AssertionError: Assertion failed

	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.visitBlockBody(ExpressionCodegen.kt:137)
	at org.jetbrains.kotlin.ir.expressions.IrBlockBody.accept(IrBlockBody.kt:20)
	at org.jetbrains.kotlin.backend.jvm.codegen.ExpressionCodegen.generate(ExpressionCodegen.kt:239)
	at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.doGenerate(FunctionCodegen.kt:121)
	at org.jetbrains.kotlin.backend.jvm.codegen.FunctionCodegen.generate(FunctionCodegen.kt:46)
	... 59 more


Execution failed for task ':compileKotlin'.
> A failure occurred while executing org.jetbrains.kotlin.compilerRunner.GradleCompilerRunnerWithWorkers$GradleKotlinCompilerWorkAction
   > Internal compiler error. See log for more details
```

Note that the setup uses `-Xuse-fir-lt=false` because without it scripts are simply ignored.
