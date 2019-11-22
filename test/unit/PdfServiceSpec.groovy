import pdf.PdfService
import spock.lang.Specification

class PdfServiceSpec extends Specification {

    def "It can create a controller"() {
        expect:
        new PdfService()
    }
}
