context("Adds post to page", () => {

    it("Adds a post", () => {
        cy.visit('http://localhost:8080')
        cy.wait(1000)
        cy.get("#newPost").type("My new post")
        cy.get("#postForm").submit()
        cy.wait(1000)
        cy.contains("My new post")
    })

})