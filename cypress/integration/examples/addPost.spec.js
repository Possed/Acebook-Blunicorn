context("Adds post to page", () => {

    beforeEach(() => {
            cy.visit('http://localhost:8080');
            cy.get('input[name=username]').type("admin");
            cy.get('input[name=password').type("password");
            cy.get('#loginForm').submit();
        })

    it("Adds a post", () => {
        cy.get("#newPost").type("My new post")
        cy.get("#postForm").submit()
        cy.contains("My new post")
    })

})