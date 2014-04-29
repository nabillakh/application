import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_menues_mainleft_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/menues/_mainleft.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('set','g',26,['var':("affichage"),'value':(1)],-1)
printHtmlPart(1)
createClosureForHtmlPart(2, 1)
invokeTag('miniMessagerie','messagerie',32,[:],1)
printHtmlPart(3)
invokeTag('set','g',34,['var':("affichageKanban"),'value':(1)],-1)
printHtmlPart(4)
createClosureForHtmlPart(5, 1)
invokeTag('kanbanmini','kanbans',39,[:],1)
printHtmlPart(6)
expressionOut.print(request.contextPath)
printHtmlPart(7)
createTagBody(1, {->
invokeTag('username','sec',100,[:],-1)
})
invokeTag('ifLoggedIn','sec',100,[:],1)
printHtmlPart(8)
createClosureForHtmlPart(9, 1)
invokeTag('link','g',114,['action':("index"),'controller':("Login")],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',118,['action':("index"),'controller':("Logout")],2)
printHtmlPart(13)
})
invokeTag('ifLoggedIn','sec',119,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(11)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',121,['action':("index"),'controller':("Login")],2)
printHtmlPart(13)
})
invokeTag('ifNotLoggedIn','sec',122,[:],1)
printHtmlPart(16)
createClosureForHtmlPart(17, 1)
invokeTag('link','g',129,['action':("index"),'controller':("mail")],1)
printHtmlPart(18)
createClosureForHtmlPart(19, 1)
invokeTag('link','g',136,['action':("activite"),'controller':("activite")],1)
printHtmlPart(10)
createClosureForHtmlPart(20, 1)
invokeTag('link','g',139,['action':("indicateur"),'controller':("activite")],1)
printHtmlPart(21)
createClosureForHtmlPart(22, 1)
invokeTag('link','g',142,['action':("portefeuille"),'controller':("activite")],1)
printHtmlPart(23)
createClosureForHtmlPart(24, 1)
invokeTag('link','g',147,['action':("index"),'controller':("event")],1)
printHtmlPart(25)
createClosureForHtmlPart(26, 1)
invokeTag('link','g',155,['action':("ressource"),'controller':("administration")],1)
printHtmlPart(27)
createClosureForHtmlPart(28, 1)
invokeTag('link','g',158,['action':("activite"),'controller':("administration")],1)
printHtmlPart(29)
invokeTag('set','g',171,['var':("calcul"),'value':(1)],-1)
printHtmlPart(30)
createClosureForHtmlPart(31, 1)
invokeTag('gaucheMessagerie','messagerie',177,[:],1)
printHtmlPart(32)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398251542854L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
