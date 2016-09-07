#!groovy

node {
    stage 'Checkout'
    git url: 'https://github.com/open-devops/OrganizationService.git'

    stage 'Compile'
    sh "mvn clean source:jar"

    stage 'Analyse'
    sh "mvn javadoc:javadoc checkstyle:checkstyle pmd:pmd findbugs:findbugs"
    step([$class: 'JUnitResultArchiver', allowEmptyResults: true, testResults: '**/target/surefire-reports/TEST-*.xml'])
    step([$class: 'JavadocArchiver', javadocDir: 'target/site/apidocs/'])

    stage 'Package'
    sh "mvn package"
    step([$class: 'ArtifactArchiver', artifacts: 'target/*.jar'])
    
    stage 'Build Image'
    sh "mvn docker:build"
}
