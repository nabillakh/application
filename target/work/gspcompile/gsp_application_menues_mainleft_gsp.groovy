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
createTagBody(1, {->
invokeTag('username','sec',98,[:],-1)
})
invokeTag('ifLoggedIn','sec',98,[:],1)
printHtmlPart(7)
createClosureForHtmlPart(8, 1)
invokeTag('link','g',113,['action':("index"),'controller':("Login")],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',117,['action':("index"),'controller':("Logout")],2)
printHtmlPart(12)
})
invokeTag('ifLoggedIn','sec',118,[:],1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(10)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',120,['action':("index"),'controller':("Login")],2)
printHtmlPart(12)
})
invokeTag('ifNotLoggedIn','sec',121,[:],1)
printHtmlPart(15)
createClosureForHtmlPart(16, 1)
invokeTag('link','g',128,['action':("index"),'controller':("mail")],1)
printHtmlPart(17)
createClosureForHtmlPart(18, 1)
invokeTag('link','g',135,['action':("activite"),'controller':("activite")],1)
printHtmlPart(9)
createClosureForHtmlPart(19, 1)
invokeTag('link','g',138,['action':("indicateur"),'controller':("activite")],1)
printHtmlPart(20)
createClosureForHtmlPart(21, 1)
invokeTag('link','g',141,['action':("index"),'controller':("kanban")],1)
printHtmlPart(22)
createClosureForHtmlPart(23, 1)
invokeTag('link','g',146,['action':("index"),'controller':("event")],1)
printHtmlPart(24)
createClosureForHtmlPart(25, 1)
invokeTag('link','g',154,['action':("ressource"),'controller':("administration")],1)
printHtmlPart(26)
createClosureForHtmlPart(27, 1)
invokeTag('link','g',157,['action':("activite"),'controller':("administration")],1)
printHtmlPart(28)
invokeTag('set','g',170,['var':("calcul"),'value':(1)],-1)
printHtmlPart(29)
createClosureForHtmlPart(30, 1)
invokeTag('gaucheMessagerie','messagerie',176,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1399048211260L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
