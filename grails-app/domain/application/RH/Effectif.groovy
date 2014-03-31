package application.RH

class Effectif {

	transient springSecurityService

	
        String username
	String password
       	boolean enabled = true
	boolean accountExpired =false
	boolean accountLocked = false
	boolean passwordExpired 
        
    
	static hasMany = [followed:Effectif]
	static searchable = [only: 'username']

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Droit> getAuthorities() {
		EffectifDroit.findAllByEffectif(this).collect { it.droit } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
