grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// maven release stuff
//grails.project.repos.Pdf.url = "https://mynexus/content/repositories/myrepository"
//grails.project.repos.Pdf.type = "maven"
//grails.project.repos.Pdf.username = System.getenv('NEXUS_USER')
//grails.project.repos.Pdf.password = System.getenv('NEXUS_PASS')
//grails.project.repos.default = "Pdf"

def required(String environmentVariable) {
    def result = System.getenv(environmentVariable)
    if (!result) {
        throw new RuntimeException("Missing ${environmentVariable} from environment variables")
    } else {
        result
    }
}

grails.project.fork = [
        // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
        //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

        // configure settings for the test-app JVM, uses the daemon by default
// HSC:    http://dmitrijs.artjomenko.com/2014/04/illegalstateexception-method-on-class.html
        test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
        // configure settings for the run-app JVM
        run: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
        // configure settings for the run-war JVM
        war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
        // configure settings for the Console UI JVM
        console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()

        //mavenRepo("https://mynexus/content/repositories/myrepository/") {
        //    auth([username: required('NEXUS_USER'), password: required('NEXUS_PASS')])
        //}
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.5'
    }

    plugins {
        runtime /*":hibernate4:4.3.6.1" or*/ ":hibernate:3.6.10.18"

        build(":release:3.1.2",
                ":rest-client-builder:2.1.1") {
            export = false
        }
    }
}
