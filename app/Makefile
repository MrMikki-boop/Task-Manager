# Makefile
.DEFAULT_GOAL := build-run


setup:make
	gradle wrapper --gradle-version 8.4

check-deps:
	./gradlew dependencyUpdates -Drevision=release

build:
	./gradlew clean build

install:
	./gradlew clean installDist

assemble:
	./gradlew assemble

run-dist: # Run app
		./build/install/app/bin/app

start:
	./gradlew bootRun --args='--spring.profiles.active=development'

start-prod:
	./gradlew bootRun --args='--spring.profiles.active=production'

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