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
        stage("Build Images") {
            steps {
                script {
                    docker.build("wildfly", "docker/wildfly")
                    docker.build("www", "docker/nginx")
                    docker.build("mysql", "docker/mysql")
                    docker.build("phpmyadmin", "docker/phpmyadmin")
                }
            }
        }
        stage('Deploy') {
            agent any
            steps {
                sh 'echo "docker push needs credentials, I do not check that in."'
            }
        }

    }
}