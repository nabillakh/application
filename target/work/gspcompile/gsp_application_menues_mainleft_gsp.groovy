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
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
invokeTag('username','sec',97,[:],-1)
})
invokeTag('ifLoggedIn','sec',97,[:],2)
})
invokeTag('link','g',97,['action':("show"),'controller':("Effectif"),'id':(sec.loggedInUserInfo(field:"id"))],1)
printHtmlPart(6)
createClosureForHtmlPart(7, 1)
invokeTag('link','g',112,['action':("index"),'controller':("Login")],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('link','g',116,['action':("index"),'controller':("Logout")],2)
printHtmlPart(11)
})
invokeTag('ifLoggedIn','sec',117,[:],1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(9)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',119,['action':("index"),'controller':("Login")],2)
printHtmlPart(11)
})
invokeTag('ifNotLoggedIn','sec',120,[:],1)
printHtmlPart(14)
createClosureForHtmlPart(15, 1)
invokeTag('link','g',127,['action':("index"),'controller':("mail")],1)
printHtmlPart(16)
createClosureForHtmlPart(17, 1)
invokeTag('link','g',134,['action':("activite"),'controller':("activite")],1)
printHtmlPart(8)
createClosureForHtmlPart(18, 1)
invokeTag('link','g',137,['action':("indicateur"),'controller':("activite")],1)
printHtmlPart(19)
createClosureForHtmlPart(20, 1)
invokeTag('link','g',140,['action':("index"),'controller':("kanban")],1)
printHtmlPart(21)
createClosureForHtmlPart(22, 1)
invokeTag('link','g',149,['action':("index"),'controller':("pic")],1)
printHtmlPart(8)
createClosureForHtmlPart(23, 1)
invokeTag('link','g',152,['action':("index"),'controller':("pdp")],1)
printHtmlPart(24)
createClosureForHtmlPart(25, 1)
invokeTag('link','g',157,['action':("index"),'controller':("event")],1)
printHtmlPart(26)
createClosureForHtmlPart(27, 1)
invokeTag('link','g',161,['action':("feuilleImputation"),'controller':("imputation")],1)
printHtmlPart(28)
createClosureForHtmlPart(29, 1)
invokeTag('link','g',169,['action':("ressource"),'controller':("administration")],1)
printHtmlPart(30)
createClosureForHtmlPart(31, 1)
invokeTag('link','g',172,['action':("activite"),'controller':("administration")],1)
printHtmlPart(32)
invokeTag('set','g',185,['var':("calcul"),'value':(1)],-1)
printHtmlPart(33)
createClosureForHtmlPart(34, 1)
invokeTag('gaucheMessagerie','messagerie',191,[:],1)
printHtmlPart(35)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1400657331679L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
