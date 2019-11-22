import pdf.PdfController
import spock.lang.Specification

class PdfControllerSpec extends Specification {

    def "It can create a controller"() {
        expect:
        new PdfController()
    }
}
