pipeline{
	agent any
    tools { 
        maven 'MAVEN' 
        jdk 'jdk8' 
    }	
	stages {
		stage('build'){
			steps{
				bat 'mvn -v'
			}
		}
	}
}
		