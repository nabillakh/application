import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_menues_leftmail_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/menues/_leftmail.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(request.contextPath)
printHtmlPart(1)
expressionOut.print(mailNonLu.size())
printHtmlPart(2)
expressionOut.print(mailNonLu.size())
printHtmlPart(3)
invokeTag('set','g',40,['var':("counter"),'value':(0)],-1)
printHtmlPart(4)
loop:{
int i = 0
for( mailEffectifInstance in (mesEffectifsMails) ) {
printHtmlPart(5)
invokeTag('set','g',42,['var':("imagenlu"),'value':(mailEffectifInstance.lu)],-1)
printHtmlPart(5)
invokeTag('set','g',43,['var':("counter"),'value':(counter+1)],-1)
printHtmlPart(6)
if(true && (counter <= 4)) {
printHtmlPart(7)
if(true && (imagenlu == false)) {
printHtmlPart(8)
expressionOut.print(request.contextPath)
printHtmlPart(9)
}
else {
printHtmlPart(8)
expressionOut.print(request.contextPath)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
expressionOut.print(mailEffectifInstance.mail.objet)
printHtmlPart(13)
expressionOut.print(mailEffectifInstance.mail.author.username)
printHtmlPart(14)
expressionOut.print(mailEffectifInstance.mail.message)
printHtmlPart(15)
})
invokeTag('link','g',62,['controller':("MailEffectif"),'action':("show"),'id':(mailEffectifInstance.id)],3)
printHtmlPart(16)
}
printHtmlPart(17)
i++
}
}
printHtmlPart(18)
createClosureForHtmlPart(19, 1)
invokeTag('link','g',69,['action':("index"),'controller':("mail"),'id':("go-to-inbox")],1)
printHtmlPart(20)
expressionOut.print(request.contextPath)
printHtmlPart(21)
createTagBody(1, {->
invokeTag('username','sec',170,[:],-1)
})
invokeTag('ifLoggedIn','sec',170,[:],1)
printHtmlPart(22)
createClosureForHtmlPart(23, 1)
invokeTag('link','g',184,['action':("index"),'controller':("Login")],1)
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(25)
createClosureForHtmlPart(26, 2)
invokeTag('link','g',188,['action':("index"),'controller':("Logout")],2)
printHtmlPart(27)
})
invokeTag('ifLoggedIn','sec',189,[:],1)
printHtmlPart(28)
createTagBody(1, {->
printHtmlPart(25)
createClosureForHtmlPart(29, 2)
invokeTag('link','g',191,['action':("index"),'controller':("Login")],2)
printHtmlPart(27)
})
invokeTag('ifNotLoggedIn','sec',192,[:],1)
printHtmlPart(30)
createClosureForHtmlPart(31, 1)
invokeTag('link','g',205,['action':("portefeuille"),'controller':("activite")],1)
printHtmlPart(32)
createClosureForHtmlPart(33, 1)
invokeTag('link','g',208,['action':("activite"),'controller':("activite")],1)
printHtmlPart(34)
expressionOut.print(request.contextPath)
printHtmlPart(35)
expressionOut.print(request.contextPath)
printHtmlPart(36)
expressionOut.print(request.contextPath)
printHtmlPart(37)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398073928130L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
