pipeline {
    agent any

    environment {
            SQ_TOKEN = credentials('Token-für-Zugriff-auf-SonarQube')
                }

    stages {
        stage('Compile') {
            steps {

                git 'https://github.com/ISTQB-Tester-Training/2023-03-CTAL-ATT-Online-01-ContinuousIntegration-Showcase.git'

                sh "mvn compile"
            }
        }
        stage('Unit Tests TDD') {
            steps {

                sh "mvn test -P TDD"
            }
        }
        stage('Code Analysis') {

            steps {
              withSonarQubeEnv('ctp-sonarqube') {
                  sh "mvn verify sonar:sonar -DskipTests"
                  }
            }
        }
        stage('Behavior Tests BDD') {
            steps {

               sh "mvn test -P BDD"
            }
        }
        stage('Deploy to Local Repository') {
            steps {

                sh "mvn package -DskipTests"
            }
        }
        stage('Deploy to Remote Repository') {
            steps {

                sh "mvn deploy -DskipTests"
            }
        }
    }
}
