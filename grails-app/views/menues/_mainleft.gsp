<div class="height-wrapper"> 

		<header>
			<!-- tool bar -->
			<div id="header-toolbar" class="container-fluid">
				<!-- .contained -->
				<div class="contained">
					
					<!-- theme name -->
					<h1> SysProd <span class="hidden-phone">- Mon tableau de bord</span> </h1>
					<!-- end theme name -->
																		
					<!-- span4 -->
					<div class="pull-right">
						<!-- demo theme switcher-->
						<div id="theme-switcher" class="btn-toolbar">
							
							<!-- search and log off button for phone devices -->
							<div class="btn-group pull-right visible-phone">
								<a href="javascript:void(0)" class="btn btn-inverse btn-small"><i class="icon-search"></i></a>
								<a href="login.html" class="btn btn-inverse btn-small"><i class="icon-off"></i></a>
							</div>
							<!-- end buttons for phone device -->
							
							<!-- dropdown mini-inbox-->
                                                        
                                                        <div class="btn-group">
                                                          
                                                          <!-- new mail ticker -->
                                                                <g:remoteLink name="miniBox" on404="alert('not found!')" update="mesMails"
                                                                              url="[controller: 'Mail', action:'maListe']">
                                                                  <a href="javascript:void(0)" class="btn btn-small btn-inverse dropdown-toggle" data-toggle="dropdown">
                                                                    <span class="mail-sticker">3</span>
                                                                    <i class="cus-email"></i>
                                                                  </a>
                                                                </g:remoteLink>
                                                          <!-- email lists -->
                                                          
                                                         <div class="dropdown-menu toolbar pull-right">
									<h3>Inbox</h3>
									<ul id="mailbox-slimscroll-js" class="mailbox">
                                                                                <g:set var="counter" value="${0}" /> 
                                                                                <g:each in="${mesEffectifsMails}" status="i" var="mailEffectifInstance">
                                                                                <g:set var="imagenlu" value="${mailEffectifInstance.lu}" />
                                                                                <g:set var="counter" value="${counter+1}" />   
                                                                                  
                                                                                          <g:if test="${counter <= 4}">
                                                                                                <g:if test="${imagenlu == false}">
                                                                                                    <img src="${request.contextPath}/img/email-unread.png" alt="important mail">
                                                                                                </g:if>
                                                                                                   <g:else>
                                                                                                    <img src="${request.contextPath}/img/email-read.png" alt="important mail">
                                                                                                  </g:else>
                                                                                                     
                                                                                 <li>        
                                                                            <g:link  controller="MailEffectif"  action="show"  id="${mailEffectifInstance.id}">   
                                                                                     
                                                                                          
                                                                                           ${mailEffectifInstance.mail.objet}: ${mailEffectifInstance.mail.author.username}
                                                                                          
																			
                                                                                             <span class="tiny-des">${mailEffectifInstance.mail.message}</span>
                                                                                         
                                                                                </g:link>
                                                                                    </li>
                                                                                   </g:if>
                                                                                 </g:each>
										
									</ul>
									 <g:link  action="index" controller="mail" id="go-to-inbox">Go to Inbox <i class="icon-double-angle-right"></i></g:link>
                                                                        
								</div>
                                                            
                                                          
                                                          <!-- end new mail ticker -->
                                                          
                                                          
                                                        </div>                                                        
                                                        
							<!-- end dropdown mini-inbox-->
							
							<!-- Tasks -->
							<div class="btn-group hidden-phone">
								<a href="javascript:void(0)" class="btn btn-inverse btn-small">My Tasks</a>
								<a href="javascript:void(0)" class="btn btn-inverse dropdown-toggle btn-small" data-toggle="dropdown"><span class="caret"></span></a>
					
								<div class="dropdown-menu toolbar pull-right">
									<h3>Showing All Tasks</h3>
									<ul class="progressbox">
						                <li>
						                    <strong><i class="online pull-left"></i>Urgent Bug Fixes</strong><b>Complete</b>
						                    <div class="progress progress-success slim"><div class="bar" style="width: 100%;"></div></div>
						                </li>
						                <li>
						                    <strong>Added functionality</strong><b>70%</b>
						                    <div class="progress progress-info slim"><div class="bar" style="width: 70%;"></div></div>
						                </li>
						                <li>
						                    <strong>CAD Changes</strong><b>50%</b>
						                    <div class="progress progress-info slim"><div class="bar" style="width: 50%;"></div></div>
						                </li>
						                <li>
						                    <strong>Marketing Campaign Mocup</strong><b>22%</b>
						                    <div class="progress progress-danger slim"><div class="bar" style="width: 22%;"></div></div>
						                </li>
						                <li>
						                    <strong><i class="offline pull-left"></i>Proposal</strong><b>Pending</b>
						                    <div class="progress progress-info slim"><div class="bar" style="width: 0%;"></div></div>
						                </li>
						            </ul>
								</div>

							</div>
							<!-- end Tasks -->
							
							<!-- theme dropdown -->
							<div class="btn-group hidden-phone">
								<a href="javascript:void(0)" class="btn btn-small btn-inverse" id="reset-widget"><i class="icon-refresh"></i></a>
								<a href="javascript:void(0)" class="btn btn-small btn-inverse dropdown-toggle" data-toggle="dropdown">Themes <span class="caret"></span></a>
								<ul id="theme-links-js" class="dropdown-menu toolbar pull-right">
									<li>
										<a href="javascript:void(0)" data-rel="purple"><i class="icon-sign-blank purple-icon"></i>Royal Purple</a>
									</li>
									<li>
										<a href="javascript:void(0)" data-rel="blue"><i class="icon-sign-blank navyblue-icon"></i>Navy Blue</a>
									</li>
									<li>
										<a href="javascript:void(0)" data-rel="green"><i class="icon-sign-blank green-icon "></i>Emerald</a>
									</li>
									<li>
										<a href="javascript:void(0)" data-rel="darkred"><i class="icon-sign-blank red-icon "></i>Dark Rose</a>
									</li>
									<li>
										<a href="javascript:void(0)" data-rel="default"><i class="icon-sign-blank grey-icon"></i>Default</a>
									</li>
								</ul>
							</div>
							<!-- end theme dropdown-->
							
						</div>
					  	<!-- end demo theme switcher-->
					</div>
					<!-- end span4 -->
				</div>
				<!-- end .contained -->
			</div>
			<!-- end tool bar -->
			
		</header>
<!-- aside -->	
		
		<div id="main" role="main" class="container-fluid">
	    	
			<div class="contained">			
<aside>	
					
					<!-- search box -->
					<div class="main-search">
						<label for="main-search"><i class="icon-search"></i></label>
	                    <input id="main-search" type="text" placeholder="Recherche">
                	</div>
					<div class="divider"></div>
					<!-- end search box -->
										
					<!-- aside item: Mini profile -->
					<div class="my-profile">
						<a href="javascript:void(0)" class="my-profile-pic">
							<img src="${request.contextPath}/img/avatar/avatar_0.jpg" alt="" />
						</a>
                                          Bienvenue
                                          <sec:ifLoggedIn><sec:username/></sec:ifLoggedIn>
					<span><a href="javascript:void(0);">Modifier profil </a></span>
					</div>
					<div class="divider"></div>
					<!-- end aside item: Mini profile -->

					<!-- aside item: Menu -->
					<div class="sidebar-nav-fixed">
						
						<ul class="menu" id="accordion-menu-js">
							<li class="current">
								<a href="javascript:void(0)"><i class="icon-off"></i>Tableau de bord <span class="badge">2</span></a>
								<ul>
									<li>
										<g:link  action="index" controller="Login">Tableau de bord</g:link>
									</li>
									<li>
                                                                                <sec:ifLoggedIn>
										 <g:link  action="index" controller="Logout">  Se déconnecter </g:link>
                                                                                 </sec:ifLoggedIn>
                                                                        <sec:ifNotLoggedIn>
										 <g:link  action="index" controller="Login">  Se connecter </g:link>
                                                                                 </sec:ifNotLoggedIn>
                                                                        
									</li>
								</ul>
							</li>
                                                        
							<li class="">
								<a href="mail"><i class="icon-envelope"></i>Boite de réception</a>
							</li>
							<li class="">
								<a href="javascript:void(0)"><i class="icon-check"></i>Suvi d'activités<span class="badge">3</span></a>
								<ul>
                                                                        <li>
                                                                                <g:link  action="portefeuille" controller="activite"> Portefeuille d'activité </g:link>
									</li>	
                                                                    <li>
                                                                                <g:link  action="activite" controller="activite">  Mon activité </g:link>
									</li>
									<li>
										<a href="validation.html">eeeeee</a>
									</li>
									<li>
										<a href="wizard.html">Mes indicateurs</a>
									</li>
								</ul>
							</li>
                                                        <li class="">
								<a href="mail"><i class="icon-envelope"></i>Mon agenda</a>
							</li>

							<li class="">
								<a href="javascript:void(0)"><i class="icon-signal"></i>Charts &amp; Graphs<span class="badge">3</span></a>
								<ul>
									<li>
										<a href="basic">Basic Charts</a>
									</li>
									<li>
										<a href="adv_charts.html">Advanced Charts</a>
									</li>
									<li>
										<a href="raphael.html">Raphael Engine</a>
									</li>
								</ul>
							</li>
							<li class="">
								<a href="widgets.html"><i class="icon-refresh"></i>Smart Widgets</a>
							</li>
							<li class="">
								<a href="javascript:void(0)"><i class="icon-plus"></i>Administration</a>
								<ul>
									<li>
										<a href="administration/ressource">Gestion des ressources</a>
									</li>
									<li>
										<a href="administration/activite">Gestion d'activite</a>
									</li>
								</ul>
							</li>
						</ul>
						
					</div>
					<div class="divider"></div>
					<!-- end aside item: Menu -->
					
					<!-- aside item: Inbox -->
					<!-- inbox message 1-->
					<div class="mini-inbox">
						<div class="alert inbox">
							<button type="button" class="close" data-dismiss="alert">
								×
							</button>
							
							<a href="javascript:void(0)">
								<img src="${request.contextPath}/img/email-important.png" width="22" height="18" alt="important mail" />
								From:David S...
							</a>
							Dear Victoria, Congratulations! You work has been uploade...
						</div>
						<!-- inbox message 2-->
						<div class="alert inbox">
							<button type="button" class="close" data-dismiss="alert">
								×
							</button>
							<a href="javascript:void(0)">
								<img src="${request.contextPath}/img/email-unread.png" width="22" height="18" alt="important mail" />
								Re:Last Year...
							</a>
							Hey Vicky, find attached! Thx :-)
						</div>
						<!-- inbox message 3-->
						<div class="alert inbox last-child">
							<button type="button" class="close" data-dismiss="alert">
								×
							</button>
							<a href="javascript:void(0)">
								<img src="${request.contextPath}/img/email-unread.png" width="22" height="18" alt="important mail" />
								Company Party
							</a>
							Hi, You have been cordially invited to join new year...
						</div>
						
					</div>
					<div class="divider"></div>
					<!-- end aside item: Inbox -->
					
					<!-- aside item: Tiny Stats -->
					<div class="number-stats">
				    	<ul>
				        	<li>4579<span>visitors</span></li>
				            <li>571<span>orders</span></li>
				            <li>879<span>reviews</span></li>
				        </ul>
				    </div>
				    <div class="divider"></div>
					<!-- end aside item: Tiny Stats -->
					
		            <!-- end aside buttons -->
				</aside>
        <!-- aside end -->