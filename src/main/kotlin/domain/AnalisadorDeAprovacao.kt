package domain

import domain.criterios.CriterioDeAprovacao

class AnalisadorDeAprovacao {
    private lateinit var criterio: CriterioDeAprovacao

    fun defineCriterio (criterioDeAprovacao: CriterioDeAprovacao) {
        this.criterio = criterioDeAprovacao
    }

    fun fechaBoletim (boletim: Boletim): BoletimFechado {
        return BoletimFechado(
            boletim.mediaEPs,
            boletim.mediaMiniEPs,
            this.criterio.mediaFinal(boletim),
            this.criterio.estaAprovado(boletim)
        )
    }
}