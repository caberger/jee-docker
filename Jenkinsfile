pipeline {
    agent none
    
    stages {
        stage('prepare') {
            agent any
            steps {
                sh 'pwd && ls -l'
            }
        }
        stage('Build') {
            agent {
                docker {
                    
                    image 'maven:latest'
                    args '-v $HOME/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn clean package'
            }
        }
    }
}