import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_kanbanshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/kanban/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
invokeTag('javascript','g',6,['library':("jquery"),'plugin':("jquery")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(5)
invokeTag('render','g',10,['template':("/menues/mainleft")],-1)
printHtmlPart(6)
expressionOut.print(request.contextPath)
printHtmlPart(7)
expressionOut.print(kanbanInstance?.nomKanban)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
expressionOut.print(kanbanInstance?.famille.nom)
printHtmlPart(10)
})
invokeTag('link','g',26,['action':("show"),'controller':("Famille"),'id':(" ${kanbanInstance.famille.id}")],1)
printHtmlPart(11)
expressionOut.print(kanbanInstance.id)
printHtmlPart(12)
expressionOut.print(request.contextPath)
printHtmlPart(13)
expressionOut.print(kanbanInstance.id)
printHtmlPart(14)
expressionOut.print(request.contextPath)
printHtmlPart(15)
expressionOut.print(kanbanInstance.id)
printHtmlPart(16)
expressionOut.print(request.contextPath)
printHtmlPart(17)
expressionOut.print(kanbanInstance.id)
printHtmlPart(18)
expressionOut.print(request.contextPath)
printHtmlPart(19)
invokeTag('remoteFunction','g',75,['controller':("kanban"),'action':("information"),'params':("\'kanban=\' + ${kanbanInstance.id}"),'update':("contenu2")],-1)
printHtmlPart(20)
invokeTag('remoteFunction','g',93,['controller':("kanban"),'action':("obtenirJournal"),'params':("\'kanban=\' + monId"),'update':("contenu2")],-1)
printHtmlPart(21)
invokeTag('remoteFunction','g',96,['controller':("kanban"),'action':("obtenirKanbanEffectif"),'params':("\'effectif=\' + monId"),'update':("contenu2")],-1)
printHtmlPart(22)
invokeTag('remoteFunction','g',99,['controller':("kanban"),'action':("indicateurKanban"),'params':("\'kanban=\' + monId"),'update':("contenu2")],-1)
printHtmlPart(23)
invokeTag('remoteFunction','g',102,['controller':("kanban"),'action':("information"),'params':("\'kanban=\' + monId"),'update':("contenu2")],-1)
printHtmlPart(24)
invokeTag('render','g',114,['template':("/menues/mainright")],-1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043381L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
