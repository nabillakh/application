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
printHtmlPart(7)
createTagBody(2, {->
invokeTag('username','sec',82,[:],-1)
})
invokeTag('ifLoggedIn','sec',82,[:],2)
})
invokeTag('link','g',82,['action':("show"),'controller':("Effectif"),'id':(sec.loggedInUserInfo(field:"id"))],1)
printHtmlPart(8)
createClosureForHtmlPart(9, 1)
invokeTag('link','g',97,['action':("index"),'controller':("Login")],1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',101,['action':("index"),'controller':("Logout")],2)
printHtmlPart(13)
})
invokeTag('ifLoggedIn','sec',102,[:],1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(11)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',104,['action':("index"),'controller':("Login")],2)
printHtmlPart(13)
})
invokeTag('ifNotLoggedIn','sec',105,[:],1)
printHtmlPart(16)
createClosureForHtmlPart(17, 1)
invokeTag('link','g',112,['action':("index"),'controller':("mail")],1)
printHtmlPart(18)
createClosureForHtmlPart(19, 1)
invokeTag('link','g',119,['action':("activite"),'controller':("activite")],1)
printHtmlPart(10)
createClosureForHtmlPart(20, 1)
invokeTag('link','g',122,['action':("indicateur"),'controller':("activite")],1)
printHtmlPart(21)
createClosureForHtmlPart(22, 1)
invokeTag('link','g',125,['action':("index"),'controller':("kanban")],1)
printHtmlPart(23)
createClosureForHtmlPart(24, 1)
invokeTag('link','g',134,['action':("index"),'controller':("pic")],1)
printHtmlPart(10)
createClosureForHtmlPart(25, 1)
invokeTag('link','g',137,['action':("index"),'controller':("pdp")],1)
printHtmlPart(26)
createClosureForHtmlPart(27, 1)
invokeTag('link','g',142,['action':("index"),'controller':("event")],1)
printHtmlPart(28)
createClosureForHtmlPart(29, 1)
invokeTag('link','g',146,['action':("feuilleImputation"),'controller':("imputation")],1)
printHtmlPart(30)
createClosureForHtmlPart(31, 1)
invokeTag('link','g',154,['action':("ressource"),'controller':("administration")],1)
printHtmlPart(32)
createClosureForHtmlPart(33, 1)
invokeTag('link','g',157,['action':("activite"),'controller':("administration")],1)
printHtmlPart(34)
invokeTag('set','g',170,['var':("calcul"),'value':(1)],-1)
printHtmlPart(35)
createClosureForHtmlPart(36, 1)
invokeTag('gaucheMessagerie','messagerie',176,[:],1)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043410L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
