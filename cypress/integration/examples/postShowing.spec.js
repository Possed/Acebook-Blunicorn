context('Post', () => {
    beforeEach(() => {
        cy.visit('http://localhost:8080')
    })

    it('Shows the post that is preloaded into the database', () => {

        cy.contains("Hey, folks! Welcome to Acebook!")

    })
})