context('Post Order', () => {

    beforeEach(() => {
        cy.visit('http://localhost:8080');
        cy.get('input[name=username]').type("admin");
        cy.get('input[name=password').type("password");
        cy.get('#loginForm').submit();
        cy.get("#newPost").type("Posted First");
        cy.get("#postForm").submit();
        cy.get("#newPost").type("Posted Second");
        cy.get("#postForm").submit();
    })

    it('Displays posts in reverse chronological order', () => {
        cy.get(".post-content").first().contains("Posted Second");
    })

    it('Displays posts in reverse chronological order', () => {
        cy.get(".posts-items:nth-of-type(2)").first().contains("Posted Second");
    })
})