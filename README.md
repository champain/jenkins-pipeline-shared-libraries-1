# Jenkins Pipeline Shared Libraries

This is a collecitons of shared libraries to be used with
[Jenkins Pipelines](https://jenkins.io/doc/book/pipeline/)
Other things to include:

  - **Technology stack**: Written in groovy/Jenkins Pipeline DSL. Requires Jenkins
  - **Status**: This repo is intended to be an ongoing effort to collect useful Pipeline libraries.


## Dependencies

This project is dependent on Jenkins Pipeline and
Jenkins >= 2.46.3, though some earlier versions may work, they have not been
tested.

## Installation

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


## Usage

Currently this repo has a `sendEmail` var that can be inovked after
importing it. Once the entire share library has been imported, `sendEmail`
is available at the top level. E.g.

```
@Library('github.com/champain/jenkins-pipeline-shared-libraries') _
pipeline {
    agent { label "master" }

    stages {
        stage("Echostage") {
            steps {
               echo "foo" 
            }
        }
    }
    post {
        always {
            script {
                sendEmail(currentBuild, ['testemail@domain.tld'])
            }
        }
    }
}"""
```

## Getting help

If you have any trouble working with this repo, please open a github issue.

## Getting involved

Adding libraries to this repo is welcome and encouraged. Should you have
an idea for a useful library or an improvement for an existing one fork
this repo and open a PR.

General instructions on contributing can be found in
[CONTRIBUTING](CONTRIBUTING.md).

----

## Open source licensing info
1. [TERMS](TERMS.md)
2. [LICENSE](LICENSE)
3. [CFPB Source Code Policy](https://github.com/cfpb/source-code-policy/)


----

## Credits and references

1. [Jenkins Pipeline](https://jenkins.io/doc/book/pipeline/shared-libraries/)
2. [Jenkins Automation](https://github.com/cfpb/jenkins-automation)
3. The wonderful [Fabric8](https://github.com/fabric8io/jenkins-pipeline-library) repo
