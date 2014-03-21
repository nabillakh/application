package application.RH

import org.apache.commons.lang.builder.HashCodeBuilder

class EffectifDroit implements Serializable {

	private static final long serialVersionUID = 1

	Effectif effectif
	Droit droit

	boolean equals(other) {
		if (!(other instanceof EffectifDroit)) {
			return false
		}

		other.effectif?.id == effectif?.id &&
			other.droit?.id == droit?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (effectif) builder.append(effectif.id)
		if (droit) builder.append(droit.id)
		builder.toHashCode()
	}

	static EffectifDroit get(long effectifId, long droitId) {
		EffectifDroit.where {
			effectif == Effectif.load(effectifId) &&
			droit == Droit.load(droitId)
		}.get()
	}

	static EffectifDroit create(Effectif effectif, Droit droit, boolean flush = false) {
		new EffectifDroit(effectif: effectif, droit: droit).save(flush: flush, insert: true)
	}

	static boolean remove(Effectif u, Droit r, boolean flush = false) {

		int rowCount = EffectifDroit.where {
			effectif == Effectif.load(u.id) &&
			droit == Droit.load(r.id)
		}.deleteAll()

		rowCount > 0
	}

	static void removeAll(Effectif u) {
		EffectifDroit.where {
			effectif == Effectif.load(u.id)
		}.deleteAll()
	}

	static void removeAll(Droit r) {
		EffectifDroit.where {
			droit == Droit.load(r.id)
		}.deleteAll()
	}

	static mapping = {
		id composite: ['droit', 'effectif']
		version false
	}
}
