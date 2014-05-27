import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_applicationindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
invokeTag('javascript','g',7,['library':("jquery"),'plugin':("jquery")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('render','g',12,['template':("/menues/mainleft")],-1)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
invokeTag('username','sec',26,[:],-1)
printHtmlPart(9)
})
invokeTag('ifLoggedIn','sec',28,[:],2)
printHtmlPart(10)
expressionOut.print(request.contextPath)
printHtmlPart(11)
expressionOut.print(request.contextPath)
printHtmlPart(12)
expressionOut.print(request.contextPath)
printHtmlPart(13)
expressionOut.print(request.contextPath)
printHtmlPart(14)
expressionOut.print(request.contextPath)
printHtmlPart(15)
invokeTag('hiddenField','g',148,['name':("kanban"),'id':("monKanban")],-1)
printHtmlPart(16)
invokeTag('remoteFunction','g',161,['controller':("message"),'action':("obtenirMessage"),'update':("newsfeed1")],-1)
printHtmlPart(17)
invokeTag('remoteFunction','g',202,['controller':("message"),'action':("posterMessage"),'params':("\'message=\'+message"),'update':("temp")],-1)
printHtmlPart(18)
invokeTag('remoteFunction','g',211,['controller':("message"),'action':("obtenirMessage"),'update':("newsfeed")],-1)
printHtmlPart(19)
invokeTag('render','g',260,['template':("/menues/mainright")],-1)
printHtmlPart(20)
})
invokeTag('ifLoggedIn','sec',265,[:],1)
printHtmlPart(21)
createTagBody(1, {->
printHtmlPart(22)
createClosureForHtmlPart(23, 2)
invokeTag('link','g',271,['action':("index"),'controller':("login")],2)
printHtmlPart(24)
})
invokeTag('ifNotLoggedIn','sec',272,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043362L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
