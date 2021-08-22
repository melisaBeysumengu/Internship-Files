import React from "react";

function StyleDiv() {
  const styleObj = {
    minWidth: 100,
    minHeight: 100,
    backgroundColor: "plum",
    textAlign: "center",
    lineHeight: "100px"
  };

  return <div style={styleObj}>This is a style div</div>;
}

export default StyleDiv;
