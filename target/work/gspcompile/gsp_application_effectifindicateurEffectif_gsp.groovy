import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_effectifindicateurEffectif_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/effectif/indicateurEffectif.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',13,['name':("messagesKanban"),'id':("messagesKanban"),'value':(messagesKanban)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',14,['name':("messagesAutre"),'id':("messagesAutre"),'value':(messagesAutre)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',15,['name':("messagesKanbanMoyen"),'id':("messagesKanbanMoyen"),'value':(messagesKanbanMoyen)],-1)
printHtmlPart(1)
invokeTag('hiddenField','g',16,['name':("messagesAutreMoyen"),'id':("messagesAutreMoyen"),'value':(messagesAutreMoyen)],-1)
printHtmlPart(2)
expressionOut.print(request.contextPath)
printHtmlPart(3)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043305L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
