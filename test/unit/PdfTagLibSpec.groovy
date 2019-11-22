import pdf.PdfTagLib
import spock.lang.Specification

class PdfTagLibSpec extends Specification {

    def "It can create a controller"() {
        expect:
        new PdfTagLib()
    }
}
