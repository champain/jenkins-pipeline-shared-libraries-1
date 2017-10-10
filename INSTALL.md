# Installation instructions

These shared libraries may be accessed one of two ways:
1. Add this repo to 'Global Pipeline Libraries' in the Jenkins UI.
1. Include this library in an `@Library` statement in a Pipeline script.

### Global Pipeline Libraries

See [this article](https://jenkins.io/doc/book/pipeline/shared-libraries/#global-shared-libraries)
about adding shared libraries via the Jenkins UI.

![](https://jenkins.io/doc/book/resources/pipeline/add-global-pipeline-libraries.png)

### Within Pipeline Script

Since this repo is hosted on github.com, it's easy to include it in all
script dynamically by adding it to the `@Library` block within a Pipeline script

```
@Library('github.com/champain/jenkins-pipeline-shared-libraries') _
```
