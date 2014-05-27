import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_kanbanobtenirJournal_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kanban/obtenirJournal.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',11,['name':("kanban"),'id':("monKanban"),'value':(kanbanInstance.id)],-1)
printHtmlPart(1)
invokeTag('remoteFunction','g',18,['controller':("message"),'action':("obtenirMessage"),'params':("\'kanban=\' + ${kanbanInstance.id}"),'update':("chatMessages")],-1)
printHtmlPart(2)
invokeTag('remoteFunction','g',30,['controller':("message"),'action':("posterMessageKanban"),'params':("\'message=\'+message+ '&kanban=\' + kanban"),'update':("temp")],-1)
printHtmlPart(3)
invokeTag('remoteFunction','g',39,['controller':("message"),'action':("obtenirMessage"),'params':("\'kanban=\' + kanban"),'update':("chatMessages")],-1)
printHtmlPart(4)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043380L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
