import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_kanbanindicateurKanban_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kanban/indicateurKanban.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(request.contextPath)
printHtmlPart(1)
expressionOut.print(request.contextPath)
printHtmlPart(2)
invokeTag('javascript','g',4,['library':("jquery"),'plugin':("jquery")],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',13,['name':("kanban"),'id':("monKanban"),'value':(kanbanInstance.nomKanban)],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',14,['name':("chargePlanifiee"),'id':("chargePlanifiee"),'value':(kanbanInstance.chargePlanifiee)],-1)
printHtmlPart(5)
loop:{
int k = 0
for( ofInstance in (kanbanInstance.of) ) {
printHtmlPart(6)
expressionOut.print(ofInstance.phase.nom)
printHtmlPart(7)
expressionOut.print(ofInstance.chargeAgenda / ofInstance.chargePlanifiee * 100)
printHtmlPart(8)
expressionOut.print(ofInstance.chargeAgenda)
printHtmlPart(9)
expressionOut.print(ofInstance.chargePlanifiee)
printHtmlPart(10)
k++
}
}
printHtmlPart(11)
expressionOut.print(request.contextPath)
printHtmlPart(12)
expressionOut.print(request.contextPath)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043377L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
