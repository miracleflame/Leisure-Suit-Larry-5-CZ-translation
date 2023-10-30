;;; Sierra Script 1.0 - (do not remove this comment)
(script# 740)
(include sci.sh)
(use Main)
(use LLRoom)
(use n958)
(use Wander)
(use Sound)
(use Cycle)
(use User)
(use PicView)
(use Obj)

(public
	rm740 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 =  1
	local6
	local7
)
(instance rm740 of LLRoom
	(properties
		picture 740
	)
	
	(method (init)
		(proc958_0 132 742 742 752 753 754 752 753 754)
		(Load rsSCRIPT 970)
		(super init:)
		(proc0_3)
		(User canControl: 0)
		(gIconBar disable: 0 3 6 7)
		(larry init:)
		(gLongSong number: 740 setLoop: -1 flags: 1 play: 127)
		(self setScript: sRoom)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(gCast contains: bodyPart)
				(!= local4 (= local3 (GetTime 1)))
			)
			(= local4 local3)
			(++ local7)
			(if (< local5 1000) (++ local5))
			(cond 
				((== local7 30) (proc0_14 740 0))
				((not (mod local7 8))
					(cond 
						((not local6) (proc0_14 740 1))
						((and (> local7 19) (< local6 5)) (proc0_14 740 2))
					)
				)
			)
		)
	)
	
	(method (dispose)
		(DisposeScript 970)
		(super dispose:)
	)
	
	(method (doVerb)
		(return 1)
	)
)

(instance sRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(proc0_14 740 3)
				(= seconds 2)
			)
			(2
				(larry
					cycleSpeed: 6
					moveSpeed: 6
					observeControl: 4
					setCycle: Fwd
					setMotion: Wander
				)
				(= seconds 3)
			)
			(3
				(proc0_14 740 4)
				(proc0_14 740 5 67 -1 185)
				(larry setMotion: 0)
				(gIconBar curIcon: (gIconBar at: 2))
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
				(Animate (gCast elements?) 0)
				(bodyPart init: perform: findWhere)
				(global2 setScript: sRoar)
			)
		)
	)
)

(instance sRoar of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 1 4)))
			(1 (soundFX number: 742 play:))
			(2 (self init:))
		)
	)
)

(instance sFadeout of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(larry
					illegalBits: 0
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 147 78 self
				)
			)
			(1
				(larry setMotion: MoveTo 131 56 self)
			)
			(2
				(gLongSong fade: 80 10 10 0)
				(if gTheNewDialog (gTheNewDialog dispose:))
				(global2 newRoom: 750)
			)
		)
	)
)

(instance bodyPart of Actor
	(properties
		description {ona}
		view 740
		signal $4000
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(self onMe: (User curEvent?))
				(not (Random 0 local5))
			)
			(= local1 1)
		)
		(if
			(and
				(not (-- local1))
				(!= (global2 script?) sFadeout)
			)
			(self perform: findWhere)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				(switch cel
					(1 (proc0_14 740 6))
					(0 (proc0_14 740 6))
					(3 (proc0_14 740 7))
					(2 (proc0_14 740 7))
					(4 (proc0_14 740 8))
					(5 (proc0_14 740 9))
					(6 (proc0_14 740 10))
				)
			)
			(3
				(larry cue: 1)
				(self perform: findWhere)
				(switch cel
					(1
						(proc0_14 740 11 67 -1 185 80 {Publikum} 30 1 108)
					)
					(0
						(proc0_14 740 12 67 -1 185 80 {Publikum} 30 1 108)
					)
					(3
						(proc0_14 740 13 67 -1 185 80 {Publikum} 30 1 108)
					)
					(2
						(proc0_14 740 14 67 -1 185 80 {Publikum} 30 1 108)
					)
					(4
						(proc0_14 740 15 67 -1 185 80 {Publikum} 30 1 108)
					)
					(5
						(proc0_14 740 16 67 -1 185 80 {Publikum} 30 1 108)
					)
					(6
						(proc0_14 740 17 67 -1 185 80 {Publikum} 30 1 108)
					)
				)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance findWhere of Code
	(properties)
	
	(method (doit param1 &tmp temp0 temp1)
		(while
			(==
				(OnControl
					4
					(= temp0 (Random 10 310))
					(= temp1 (Random 10 170))
				)
				2
			)
		)
		(param1 setCel: (Random 0 6) posn: temp0 temp1)
		(= local1 (Random 60 360))
		(= local1 (* local5 (Random 5 30)))
	)
)

(instance larry of Actor
	(properties
		x 160
		y 100
		description {ty a Lana}
		lookStr {To jsi ty a Lana, jak zápasíte, ale odsud se nemùžeš dotknout!}
		view 743
		signal $4800
	)
	
	(method (init)
		(super init:)
		(self setCycle: End)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 740 18))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
	
	(method (cue param1 &tmp temp0 temp1 temp2)
		(switch param1
			(0 (self setCycle: 0))
			(1
				(if (> local6 9)
					(proc0_2)
					(global2 setScript: sFadeout)
				else
					(patFX number: (+ 752 (/ local6 2)) play:)
					(++ local6)
					(cond 
						((< (= temp0 (GetAngle x y 153 84)) 90)
							(= temp1 (+ x (Random 10 40)))
							(= temp2 (- y (Random 10 40)))
						)
						((< temp0 180)
							(= temp1 (+ x (Random 10 40)))
							(= temp2 (+ y (Random 10 40)))
						)
						((< temp0 270)
							(= temp1 (- x (Random 10 40)))
							(= temp2 (+ y (Random 10 40)))
						)
						(else
							(= temp1 (- x (Random 10 40)))
							(= temp2 (- y (Random 10 40)))
						)
					)
					(self
						setLoop: 0
						setCycle: Fwd
						setMotion: MoveTo temp1 temp2 self
					)
				)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

(instance patFX of Sound
	(properties
		flags $0001
	)
)
