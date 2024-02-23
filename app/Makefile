# Makefile
.DEFAULT_GOAL := build-run



build: # Build app
	./gradlew clean
	./gradlew installDist

assemble:
	./gradlew assemble

run-dist: # Run app
		./build/install/app/bin/app

start:
	./gradlew bootRun --args='--spring.profiles.active=dev'

start-prod:
	./gradlew bootRun --args='--spring.profiles.active=prod'

run:
	./gradlew run

test:
		./gradlew test

report:
		./gradlew jacocoTestReport jacocoTestCoverageVerification

lint:
	./gradlew checkstyleMain checkstyleTest

lint-main:
	./gradlew checkstyleMain

lint-test:
	./gradlew  checkstyleTest

last: # Last version plugin
	./gradlew useLatestVersions

build-run: build assemble
build-test: build test report

.PHONY: build