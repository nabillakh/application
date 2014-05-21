import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_imputationligneImputation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/imputation/ligneImputation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(1)
createTagBody(1, {->
expressionOut.print(kanbanInstance.nomKanban)
})
invokeTag('link','g',3,['action':("show"),'controller':("Kanban"),'id':(kanbanInstance.id)],1)
printHtmlPart(2)
expressionOut.print(kanbanInstance.getChargeAgenda())
printHtmlPart(3)
expressionOut.print(kanbanInstance.getChargeAgenda())
printHtmlPart(3)
expressionOut.print(kanbanInstance.getChargeAgenda())
printHtmlPart(3)
expressionOut.print(kanbanInstance.getChargeAgenda())
printHtmlPart(3)
expressionOut.print(kanbanInstance.getChargeAgenda())
printHtmlPart(4)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400666378408L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
