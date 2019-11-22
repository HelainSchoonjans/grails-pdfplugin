class PdfGrailsPlugin {
    String groupId = 'org.organisation.plugin'
    // the plugin version
    def version = "0.7.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.3 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp",
            "web-app/js",
            "web-app/css"
    ]

    def author = "Aaron Eischeid"
    def authorEmail = "a.eischeid@gmail.com"
    def title = "Provides a simple way to generate PDFs from web pages"
    def description = '''
    Pdf plugin allows your Grails application to generate PDFs and send them
    to the browser by converting existing pages or templates in your application
    to PDF on the fly. The underlying system uses the xhtmlrenderer component 
    from java.net to do the rendering.
    '''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/Pdf+Plugin"
}
