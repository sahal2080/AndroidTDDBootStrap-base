android_build_config(
	name = 'build_config',
	package = 'com.github.piasy.base',
	values = [
		'String VERSION_NAME = "1.0.0"',
		'String BUILD_TYPE = "release"',
		'int VERSION_CODE = 1',
		'String FLAVOR = "default"',
	],
	visibility = [
		'PUBLIC',
	],
)

android_library(
	name = 'src',
	srcs = glob([
		'src/main/java/**/*.java',
	]),
	manifest = 'src/main/AndroidManifest.xml',
	annotation_processors = [
		'com.promegu.xlog.processor.XLogProcessor',
		'butterknife.internal.ButterKnifeProcessor',
		'com.pushtorefresh.storio.sqlite.annotations.processor.StorIOSQLiteProcessor',
		'com.google.auto.service.processor.AutoServiceProcessor',
		'auto.parcel.processor.AutoParcelProcessor',
		'com.hannesdorfmann.fragmentargs.processor.ArgProcessor',
		'auto.parcel.processor.AutoParcelBuilderProcessor',
		'dagger.internal.codegen.ComponentProcessor',
	],
	annotation_processor_deps = [
		'//.okbuck/base_apt_deps:all_jars',
		'//.okbuck/base_apt_deps:all_aars',
	],
	deps = [
		'//.okbuck/F0A6EAEEF3E542B6DDF2BCD0B88AF573:jar__okio-1.6.0.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__butterknife-7.0.1.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__dagger-2.0.2.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__eventbus-3.0.0.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__javax.annotation-10.0-b28.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:aar__mvp-2.0.1.aar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:aar__rxandroid-1.1.0.aar',
		'//.okbuck/F0A6EAEEF3E542B6DDF2BCD0B88AF573:jar__threetenbp-1.3.1-no-tzdb.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:aar__support-v4-23.1.1.aar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__rxjava-1.1.1.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__common-1.8.0.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__adapter-rxjava-2.0.0-beta4.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__sqlite-annotations-1.8.0.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:aar__timber-4.1.1.aar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:aar__rxlifecycle-0.4.0.aar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__converter-gson-2.0.0-beta4.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__xlog-2.1.1.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__sqlite-1.8.0.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__support-annotations-23.1.1.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__xlog-compiler-2.1.1.jar',
		'//.okbuck/F0A6EAEEF3E542B6DDF2BCD0B88AF573:jar__javax.inject-1.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__gson-2.6.1.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__auto-parcel-0.3.1.jar',
		'//.okbuck/F0A6EAEEF3E542B6DDF2BCD0B88AF573:aar__threetenabp-1.0.3.aar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:aar__rxlifecycle-components-0.4.0.aar',
		'//.okbuck/F0A6EAEEF3E542B6DDF2BCD0B88AF573:jar__okhttp-3.2.0.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:aar__rxbinding-0.4.0.aar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:aar__rxbinding-appcompat-v7-0.4.0.aar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__annotation-3.0.1.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__mvp-common-2.0.1.jar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:aar__appcompat-v7-23.1.1.aar',
		'//.okbuck/7C77C39AF3F379E8F1DD93B5B2FE8351:jar__retrofit-2.0.0-beta4.jar',
		':build_config',
	],
	visibility = [
		'PUBLIC',
	],
)

project_config(
	src_target = '//base:src',
	src_roots = [
		'src/main/java',
	],
)

