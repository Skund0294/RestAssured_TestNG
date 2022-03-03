pipeline{
	
	agent any
	
	tools {
        maven "My_MAVEN"
        jdk "JDK"
    }
  
  parameters{
  string(name:'Tag to execute', defaultValue:'@SampleTest')
  string(name:'Threads', defaultValue:'12')
  }
	
	stages{
		stage("Clean and Build"){
		steps{
			script{
			sh 'mvn clean install'
			}
		}
		}
		stage("Execute Tests"){
		steps{
			script{
			sh 'mvn test'
			}
		}
		}
		stage("Reporting"){
		steps{
		publishHTML (target : [allowMissing: false,
 alwaysLinkToLastBuild: true,
 keepAll: true,
 reportDir: 'ExtentReports',
 reportFiles: '*.html',
 reportName: 'Extent Reports',
 reportTitles: 'Extent Report'])
		}	
}}}