# Liferay Gradle Plugins App Javadoc Builder Change Log

## 1.1.0 - 2016-10-04

### Added
- [LPS-68506]: Add the ability to exclude subprojects from the API documentation
by using the `appJavadocBuilder.onlyIf` property.

### Changed
- [LPS-67573]: Make most methods private in order to reduce API surface.

## 1.2.0 - 2016-10-12

### Added
- [LPS-68666]: Add the ability to define which subprojects to include in the API
documentation of the app by using the `appJavadocBuilder.subprojects` property.

## 1.2.1 - 2018-11-16

### Changed
- [LPS-87466]: Update the [Liferay Gradle Util] dependency to version 1.0.32.

## 1.2.2 - 2018-11-19

### Changed
- [LPS-87466]: Update the [Liferay Gradle Util] dependency to version 1.0.33.

[Liferay Gradle Util]: https://github.com/liferay/liferay-portal/tree/master/modules/sdk/gradle-util
[LPS-67573]: https://issues.liferay.com/browse/LPS-67573
[LPS-68506]: https://issues.liferay.com/browse/LPS-68506
[LPS-68666]: https://issues.liferay.com/browse/LPS-68666
[LPS-87466]: https://issues.liferay.com/browse/LPS-87466