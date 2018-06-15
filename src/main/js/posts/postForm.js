import React from 'react';

class PostForm extends React.Component{

    constructor(props) {
        super(props);
        this.state = {};
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({value: event.target.value})
    }

    handleSubmit(event) {
        var newPost = {};
        newPost["content"] = this.state.value;
        this.props.onCreate(newPost);
        event.preventDefault();
        this.setState(value: "");
    }

	render() {
		return (
		        <div>
                    <form id="postForm" onSubmit={this.handleSubmit}>
                            <textarea c id="newPost" rows="4" style="width:100%;" value={this.state.value} onChange={this.handleChange} /><br>
                            <button class="button" type="submit">Post</button>
                    </form>
                </div>
		)
	}
}

export default PostForm;